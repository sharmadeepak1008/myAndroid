![project_screenshot](https://github.com/sharmadeepak1008/myAndroid/assets/42468752/71d71c17-efb6-40df-9372-8ed241a8c71f)
Library Used:
Jetpack Compose: without using custom layout design screen we are using this library.
Retrofit : For Http request we used retrofit in this project
okhttp-logging-interceptor- For print logs we used OkHttp logging interceptor library
Hilt - For dependcy injection we used Hilt android library.
Navigation - for navigation in the app we navigation compose library in this project.

Main Classes used in this project:
Service : Api interface class contains all api in remote under data package
UserRepositoryImpl: It contains the implemenation where User repository injected as a constructor
response : under data package reponse contains all data class for response.
di - di contains two classes Network Module in which retrofit library initialized and logging interceptor implemented with Hilt library and Repository Module
domain - In repository under domain User Repository is defined with method get users.
GetUserusecase- in this with the help of FLow we are emiting response using user repository.
navigation- it contains Navgraph and Screen for navigating user to screen 
theme- it contains color, shape etc theme 
users - UserItem contains the particular list item design with the help of jetpack compose.
Userscreen contains the lazycolumnfor showing users list, progress bar implementation untill data is not loaded and error message if internet is not available.
UsersViewmodel - in this get users method is called with the help of Getuserusecase.
