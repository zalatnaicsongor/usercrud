#CRUD app for handling users with a twist.

##--Introduction--
The core domain is handling users.

A user can be created by specifying a name and date of birth.
A users name should be changeable, also its date of birth. None of these can be empty.
Once created, a user should also be deletable.

DDD should never be applied to non-complex domains, but since I wanted to experiment a bit, this is an exception.
Many DDD apps have complex mapping layers between the persistence and the domain. I used the 'Memento' pattern to eliminate
the mapping layers. The initial experiences were good, for non-complex scenarios this approach seems usable.

Any code of interest is in the hu.zalatnai.user.domain package. All the rest are supporting packages

##--Testing--
The core domain logic was unit tested using JUnit. **Testing of the supporting classes (infrastructure services, etc.) were omitted for brevity.**
Acceptance tests should be added to ensure that the acceptance criteria were met. This should be done by using
Cucumber to define the features, and probably I'd use Rest Assured + Spring MVC integration to implement the tests.

##--Front-end--
httpie/curl/wget/... :)
See hu.zalatnai.usercrud.user.infrastructure.controller.UserController for the available endpoints.
