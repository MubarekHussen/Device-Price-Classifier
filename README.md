# Device Price Classifier

## Overview

The Device Price Classifier is an AI system developed using Python and Spring Boot. This system allows sellers to classify device prices according to their characteristics. It consists of two main components:

1. **Python Project**: This project focuses on building a machine learning model to predict device prices based on various specifications.
2. **Spring Boot Project**: This project contains RESTful endpoints to interact with the machine learning model and store device information.

## Contributors

- [Mubarek Hussen](https://github.com/MubarekHussen)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Usage

#### Python Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/MubarekHussen/Device-Price-Classifier
   cd Device-Price-Classifier/python_project
   ```

2. **Install Dependencies and Run:**

   Create a Virtual Environment:

   You can create a virtual environment using the following commands:

   - For Windows:

   ```bash
   python -m venv venv
   ```

   - For macOS and Linux:

   ```bash
   python3 -m venv venv
   ```

   Activate the Virtual Environment:

   - For Windows:

   ```bash
   venv\Scripts\activate
   ```

   - For macOS and Linux:

   ```bash
   source venv/bin/activate
   ```

   Install Dependencies:

   If it's your first time using the project or if dependencies have changed, you should install them using the following command:

   ```bash
   pip install -r requirements.txt
   ```

3. **Run the PythonAPI:**

   ```bash
   cd src
   uvicorn main:app --reload
   ```

#### Spring Boot Project

1. **Clone the Repository:**

   ```bash
   cd Device-Price-Classifier/springboot_project/classifier
   ```

2. **Install Dependencies and Run:**

   ```bash
   mvn clean install
   ```

3. **Run the Spring-boot:**

   ```bash
   mvn spring-boot:run
   ```
