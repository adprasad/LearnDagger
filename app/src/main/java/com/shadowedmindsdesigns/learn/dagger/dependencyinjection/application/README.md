Application Scoped Dagger Configuration
=
Application Scope
-
Defines a "global" scope to the application

Application Component
-
Defines what is going to be provided and what needs to be injected to provide.

Kind of like a promisary note. If you build this component I'm promising that the module(s) in charge of it will plugin the missing pieces.

Divide related services into modules and make components depend on multiple.

Services provided by a module. Are available to all modules within the same component.

Application Module
-

A real class that does the actual provisioning based on scope.

SettingsModule
-

Does not need to define pulling in "Application" because it shares the graph with the ApplicationModule so it already has access to application. This is done in the AppComponent by adding the SettingsModule in the defined modules (annotation).

So things defined in ApplicationModule are available to SettingsModule...


_Short Hand_

**_BP_** Best Practice

Do not do all injection via the Application Component.

Instructor does not advise using the new "AndroidInjector" method with generics. It is overly convoluted and does not seem to solve any problems.

Don't use lazy injection or "mint(?)". According to the instructor these cause a mix of functional and construction which breaks a tenant of DI.

Lazy Injection is rarely needed; There is another pattern described by .... I had trouble understanding the name but I think its this post: https://medium.com/@froger_mcs/async-injection-in-dagger-2-with-rxjava-e7df503343c0

 Services Injected via AppCmpt have at least one of the following characteristics:
 1. Service is global and should only be instantiated once in app lifecycle
 2. service should be injected into app object
 3. service is required by more than a single sub-component of AppCmpt