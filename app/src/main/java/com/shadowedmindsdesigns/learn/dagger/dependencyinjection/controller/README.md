Controller Scoped Dagger Configuration
=
Activity and Fragment are like Controllers im MVC. It makes sense to use a single Dagger Component to manage both as they will normally depend on the same set of services.

Controller Scope
-
Defines a "controller level" scope to the application

Controller Component
-
Defines what is going to be provided and what needs to be injected to provide.

Is a sub-component which means it is based on or part of another component. Here, the application is the parent. To establish that relationship the ApplicationComponent interface needs to be updated.

Sub-components automatically get direct access to parents DI graph which makes maintaining DI logic "easier" (according to instructor).

Use stand-alone sub-component in order to inject into Activities and Fragments.

Controller Module
-

A real class that does the actual provisioning based on scope.

Provides services required by an activity including: context, fragment support manager, a way to make dialogs or snackbar messages...

Its based out of the activity or fragment housing it. So when you build a fragment the activity it references is itself. See code.

Cannot be constructed outside of activity scope as it requires an activity to be bootstrapped.

In Actvity/Fragment Class
-
Controller component is not used to declare global services so no need for a local variable to hold this. The get will create a new version each time (?);

@Inject added for any properties provided by DI (ex. fragmentmanager) 



_Short Hand_

**_BP_** Best Practice