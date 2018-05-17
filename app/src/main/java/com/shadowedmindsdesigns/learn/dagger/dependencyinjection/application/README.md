Application Scoped Dagger Configuration
=
Application Scope
-
Defines a "global" scope to the application

Application Component
-
Defines what is going to be provided and what needs to be injected to provide.

Kind of like a promisary note. If you build this component I'm promising that the module(s) in charge of it will plugin the missing pieces.

**_BP_** Do not do all injection via the Application Component. Similar to the MVC concept; fragments, activities, etc need their own component to handle DI

Application Module
-

A real class that does the actual provisioning based on scope.


_Short Hand_

**_BP_** Best Practice