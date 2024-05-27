## Disney Movies Database

### Overview
This project is a comprehensive database for Disney movies, designed and implemented using PostgreSQL. The application includes data modeling, query optimization, and a RESTful API for interacting with the database.

### Technologies Used
- **Database:** PostgreSQL
- **Tools:** DataGrip
- **API:** Jakarta Persistence API

### Features
- Comprehensive database of Disney movies
- Optimized queries for improved performance
- Parameterized queries for secure and efficient data retrieval

### Database Setup
1. Ensure you have PostgreSQL installed on your system.
2. Create a new database for the project:
    ```sql
    CREATE DATABASE disney_movies;
    ```
3. Create the necessary tables by running the provided SQL script (`database/schema.sql`). Here is an example script you might include:
    ```sql
    -- Example schema.sql
    CREATE TABLE movies (
        id SERIAL PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        release_year INTEGER NOT NULL,
        genre VARCHAR(100),
        director VARCHAR(100),
        rating DECIMAL(3, 1)
    );

    CREATE TABLE characters (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        movie_id INTEGER REFERENCES movies(id),
        role VARCHAR(100)
    );
    ```
## Usage
1. Insert new movie records into the database.
2. Retrieve movie data using optimized and parameterized queries.
3. Manage movie characters and their roles in the database.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
