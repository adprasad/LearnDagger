### Testing
Since I was following a tutorial there are not TDD style. Need to figure out what I need to test. Am I trying to verify that DI happens?

1. Does the application level injection happen and where?
2. Does controller (activity, fragment, dialog, etc) level injection happen?

**Plan**
1. Create a test for the Example Activity
    * Verify application level service available (logger )
    * Verify controller level service available (acquire a dialog & use fragment manager)
2. Create a "TDD" style test for Settings service
    * Define a goal - put in top of Settings or Settings Test Class
    * Try Uncle Bob's 3 rules for TDD