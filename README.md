# MatcherAPI

A small api for pattern matching

With regex expression test case

TODO
- Complete regular expression pattern preparation
    ```kotlin
    // ^.*$ not available
     val reg = Regex("^.*$")
     print(reg test "userName")
 
    ```
- Complete results collection 
    ```kotlin
    var reg = Regex("^.*$")
  
    reg test "userName"
    // get size of matched results
    print(reg.result.size)
  
    while(reg.hasResults){
    // access found matches
          print(reg.next())
    }
  
    ```
- Complete section grouping
    ```kotlin
    val reg = Regex("^(.*)$")

    reg test "userName"
    // access groups
    print(reg[0])
    ```
- Complete sections naming access 
    ```kotlin
    val reg  = Regex("^<simple_name>.*$")
  
    reg test "userName"
  
    if(reg.hasRes) print(reg.simple_name)
    ```
    
# Structure basics
- Kotlin does not support static properties inheritance thus oop library
    ```kotlin
    import libs.oop.classes.Class
    import libs.oop.classes.StaticClass
    
    // Structure developed for future used somewhat cumbersome but fits my use case so far
  
    /** example use case
      *  val classes = arrayOf(A)
      *  // use of class Array
      *  for (klass in classes)  print(klass.name) 
      * */
    class AStatic : StaticClass(){
        
        val name = "simple property name"
          
        fun invoke():Class = Class()
      
        class Class : oop.Class<AStatic>(){
              override val self
        }
    }
    
    val A = AStatic()
    
    // this way we can have
    
    fun main(){
       print(A.name)
     
    }
```
Use the following Gradle commands
* to build: `./gradlew assemble`
* to test: `./gradlew check`
* to run:  `./gradlew runHelloWorldAppReleaseExecutableHelloWorld`
