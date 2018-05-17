# LearnDagger
Code from following along with basic DI tutorial using Dagger.
https://www.youtube.com/watch?v=cx6pCIbOqtI&index=6&list=WL&t=0s

###### Dependency Injection
* Complete separation of functional and construction sets of classes
* Each class should contain either functional logic OR construction to wire together functional logic but not both
* Should use standalone packages, classes, etc to ensure separation
* Dagger uses Singleton to show service as global
    * To provide clarity and readability make own scope as "application scope" 
    * Best practice is to annotate scope even if scope is global
    * Best practice is to provide application from application module but not the context from application module