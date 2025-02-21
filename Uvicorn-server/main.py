import logging
import time
from fastapi import FastAPI, Request
from fastapi.responses import Response
from fastapi.templating import Jinja2Templates
from fastapi.staticfiles import StaticFiles

# Configure logging
LOG_FILE = "logs/server.log"

logging.basicConfig(
    filename=LOG_FILE,  # Log file
    level=logging.DEBUG,  # Capture everything (DEBUG, INFO, WARNING, ERROR, CRITICAL)
    format="%(asctime)s - %(levelname)s - %(message)s",
)

# FastAPI app initialization
app = FastAPI()

# Static files and templates setup
app.mount("/static", StaticFiles(directory="static"), name="static")
templates = Jinja2Templates(directory="templates")

# Dummy data (Model)
DUMMY_PRODUCTS = [
    {"id": 1, "name": "Laptop", "price": 1500, "description": "A high-performance laptop"},
    {"id": 2, "name": "Smartphone", "price": 800, "description": "A smartphone with a great camera"},
    {"id": 3, "name": "Headphones", "price": 200, "description": "Noise-canceling headphones"},
]

# Log application startup
logging.info("Application is starting...")


# Middleware to log every request and response
@app.middleware("http")
async def log_requests(request: Request, call_next):
    start_time = time.time()

    # Log request details
    logging.info(f"Incoming request: {request.method} {request.url}")
    logging.debug(f"Headers: {dict(request.headers)}")

    # Process request
    response = await call_next(request)

    # Log response details
    duration = time.time() - start_time
    logging.info(f"Response: {response.status_code} (Processed in {duration:.4f} seconds)")

    return response


# Controller
@app.get("/")
def home(request: Request):
    logging.info("Processing homepage request")
    return templates.TemplateResponse("index.html", {"request": request, "products": DUMMY_PRODUCTS})


@app.get("/product/{product_id}")
def product_detail(request: Request, product_id: int):
    logging.info(f"Processing product request: ID {product_id}")
    product = next((p for p in DUMMY_PRODUCTS if p["id"] == product_id), None)

    if product is None:
        logging.warning(f"Product ID {product_id} not found")
        return templates.TemplateResponse("404.html", {"request": request}, status_code=404)

    return templates.TemplateResponse("product.html", {"request": request, "product": product})


# Global exception handler
@app.exception_handler(Exception)
async def global_exception_handler(request: Request, exc: Exception):
    logging.error(f"Unhandled error: {str(exc)}", exc_info=True)
    return templates.TemplateResponse("404.html", {"request": request}, status_code=500)


# Log application shutdown
@app.on_event("shutdown")
def shutdown_event():
    logging.info("Application is shutting down...")
