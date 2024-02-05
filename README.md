![project_screenshot](https://github.com/sharmadeepak1008/myAndroid/assets/42468752/71d71c17-efb6-40df-9372-8ed241a8c71f)
**Project Structure**
cleanarchitecturecomposeproject
│
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/deepak/cleanarchitecturecomposeproject
│   │   │   │   ├── ui
│   │   │   │   │   ├── users,MainActivity
│   │   │   │   │   │   ├── UsersViewModel.kt,UserItem.kt
│   │   │   │   │   │   └── UsersState.kt,UserScreen.kt
│   │   │   │   ├── domain ├──di-NetworkModule,RepositoryModule
│   │   │   │   │   ├── uimodel
│   │   │   │   │   │   └── UserUiModel.kt
│   │   │   │   │   ├── usecase└── GetUsersUseCase.kt
│   │   │   │   │   │
├── ├── ├── ├── ├── ├──data-response├──repository-UserRepositoryImpl
├── ├── ├── ├── ├── ├──domain - UserRepository,uimodel
├── ├── ├── ├── ├── ├── navigation├── NavGraph.kt,Screen.kt
│   │   │   │   ├── utils
│   │   │   │   │   └── Resource.kt,Text.Kt,CustomHttpLogger,Constants
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res
│   │   │   └── AndroidManifest.xml
│   │   ├── test
│   │   └── androidTest
│   └── build.gradle
├── build.gradle
└── settings.gradle
**Dependencies**
Dagger Hilt: Dependency injection library
Kotlin Coroutines: Asynchronous programming
JUnit and Mockito: Testing framework
Android Compose: UI toolkit
Http: Retrofit

**How to Run**
Clone the repository:
https://github.com/sharmadeepak1008/myAndroid.git
Open the project in Android Studio.

Build and run the application on an emulator or physical device.

**Testing**
Unit tests are written using JUnit and Mockito.