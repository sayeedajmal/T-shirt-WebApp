Users Table (for managing user accounts):
user_id (Primary Key): Unique identifier for each user.
username: User's username.
email: User's email address.
password_hash: Securely hashed password.
first_name: User's first name.
last_name: User's last name.
address: User's address.
phone_number: User's phone number.
registration_date: Date when the user registered.


Categories Table (for organizing products):
category_id (Primary Key): Unique identifier for each category.
name: Name of the category.
description: Description of the category.

Products Table (for storing information about T-shirts):
product_id (Primary Key): Unique identifier for each product.
name: Name of the product.
description: Description of the product.
price: Price of the product.
stock_quantity: Quantity of the product in stock.
category_id (Foreign Key): Reference to the category the product belongs to.


Images Table (for storing product images):
image_id (Primary Key): Unique identifier for each image.
product_id (Foreign Key): Reference to the product the image belongs to.
image_url: URL or path to the image file.

Orders Table (for tracking customer orders):
order_id (Primary Key): Unique identifier for each order.
user_id (Foreign Key): Reference to the user who placed the order.
order_date: Date when the order was placed.
total_amount: Total amount of the order.

OrderItems Table (for storing individual items within orders):
order_item_id (Primary Key): Unique identifier for each order item.
order_id (Foreign Key): Reference to the order the item belongs to.
product_id (Foreign Key): Reference to the product in the order.
quantity: Quantity of the product in the order.
unit_price: Price of the product at the time of the order.

Shipping Addresses Table (for recording shipping addresses for orders):
shipping_address_id (Primary Key): Unique identifier for each shipping address.
order_id (Foreign Key): Reference to the order the address is associated with.
recipient_name: Name of the recipient.
street_address: Street address for shipping.
city: City for shipping.
state: State or region for shipping.
postal_code: Postal code for shipping.
country: Country for shipping.

Payment Transactions Table (for recording payment details):
transaction_id (Primary Key): Unique identifier for each payment transaction.
order_id (Foreign Key): Reference to the order the payment is associated with.
payment_date: Date of the payment.
payment_method: Payment method used (e.g., credit card, PayPal).
payment_status: Status of the payment (e.g., pending, successful)

Returns Table (for tracking return requests and processing):
return_id (Primary Key)
order_id (Foreign Key referencing Orders)
return_date
reason (e.g., defective product, wrong size, not as described)
status (e.g., pending, approved, rejected)
refund_amount (optional, if applicable)
comments (optional, for additional notes)