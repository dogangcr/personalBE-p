
## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Docker

4. Mysql db (remotemysql)

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/dogangcr/personalBE.git
```

 
**4. Build and run the app using maven and docker **

```bash
mvn clean install -U

docker build -t personalquiz . 

docker run -p 8080:8080 personalquiz


```
 

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET 
	http://localhost:8080/api/options/user
	http://localhost:8080/api/category/user
    http://localhost:8080/api/note/user
    POST 
	http://localhost:8080/api/note/admin
	{
    "question": "What age should your potential partner be?",
    "questionType": "2",
    "categoryId": "2",
    "options": [
     {
        "id": 7,
        "options": "other",
        "dquestionID": "3"
    }
		]
		}
		
    http://localhost:8080/api/options/admin
	 {
    "options": "other",
    "dquestionID":"3"

	}

You can test them using postman or any other rest client.