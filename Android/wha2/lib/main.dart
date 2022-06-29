import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart';


void main()
{
  runApp(Patient_profile());
}

class Home extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {



    return MaterialApp(
      title: "wha",

      home: Scaffold(
        body: new Column(

          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            new Padding(

              padding: const EdgeInsets.all(0),

              child: Container(





                //  alignment: Alignment.center,
                child: Image.asset('image/logo.png'),
              ),

            ),
            new Padding(
              padding: const EdgeInsets.all(100),
              //nt: CrossAxisAlignment.ce
              child: Container(
                //crossAxisAlignment: CrossAxisAlignment.center,
                alignment: Alignment.bottomCenter,
                child: new Text("A product of"),

              ),

            ),
            new Padding(
              padding: const EdgeInsets.all(0),
              //nt: CrossAxisAlignment.ce
              child: Container(
                //crossAxisAlignment: CrossAxisAlignment.center,
                alignment: Alignment.bottomCenter,
                child: new Text("TRI"),

              ),

            )



          ],
        ),
      ),
    );


  }



}



class Welcome_page extends StatefulWidget{
  @override
  State<Welcome_page> createState() => _Welcome_pageState();
}

class _Welcome_pageState extends State<Welcome_page> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      title: "welcome",
      home: Scaffold(

        body: List()

        /*Column(
          children: [

            Container(
              child: List(),
            )

          ],

        ),*/

       /* body: ListView(

          scrollDirection: Axis.horizontal,

          children: [
            Container(
              color: Colors.deepPurpleAccent,
              child: new Text("hi"),
            ),

            Container(
              width: 20,
              color: Colors.red,
              child:  Center(
                  child: Text('Item 2', style: TextStyle(fontSize: 18, color: Colors.white),)
              ),
            ),

            Container(
              width: 20,
              color: Colors.green,
              child:  Center(
                  child: Text('Item 3', style: TextStyle(fontSize: 18, color: Colors.white),)
              ),
            ),

            Container(
              width: 20,
              color: Colors.amber,
              child:  Center(
                  child: Text('Item 4', style: TextStyle(fontSize: 18, color: Colors.white),)
              ),
            ),






          ],

        ),*/

      ),
    );
  }
}

class List extends StatefulWidget{
  @override
  State<List> createState() => _ListState();
}

class _ListState extends State<List> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: ListView(

          scrollDirection: Axis.horizontal,

          children: [
            Container(
              color: Colors.deepPurpleAccent,
              width: 200,

              child: new Text("hi"),
            ),

            Container(
              color: Colors.red,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.green,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.amber,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.deepPurpleAccent,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.red,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.green,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.amber,
              width: 200,
              child: new Text("hi"),
            ),



            Container(
              color: Colors.deepPurpleAccent,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.red,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.green,
              width: 200,
              child: new Text("hi"),
            ),

            Container(
              color: Colors.amber,
              width: 200,
              child: InkWell(
                onTap: (){



                },
              ),

            ),









          ],

        ),


        ),

    );
  }
}

class Login extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      title: "Log in",
      home: Scaffold(


      ),
    );
  }

}

class DashBoard extends StatefulWidget
{
  @override
  State<DashBoard> createState() => _DashBoardState();
}

class _DashBoardState extends State<DashBoard> {



  String selectedValue="Current medication";

  @override
  Widget build(BuildContext context) {
    // TODO: implement build


    return MaterialApp(
      home: Scaffold(

        body: Column(

          children: [

            Container(

              child: Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [

                    Container(
                      alignment: Alignment.centerLeft,
                      child: Image.asset('image/logo.png'),
                    ),

                    Container(
                      child: Text("User name"),
                      alignment: Alignment.center,
                    ),

                    Container(
                      child: Text("User name"),
                      alignment: Alignment.center,
                    ),

                    Column(
                      children: [
                        Container(
                          child: Image.asset('image/call.jpg') ,
                          alignment: Alignment.centerRight,
                        ),
                        Container(
                          child: Image.asset('image/call cut.jpg') ,

                          alignment: Alignment.centerRight,
                        )
                      ],


                    )

                  ],
                ),
              ),

            ),

            /*GridView.count(
                crossAxisCount: 2,
                crossAxisSpacing: 20,
                mainAxisSpacing: 20,
                children: [
                  GridTile(
                      child: Container(
                        child: Text("Appointment"),
                        color: Colors.green,
                      ),

                  ),

                  GridTile(
                    child: Text("Appointment"),

                  ),
                  GridTile(
                    child: Text("Appointment"),

                  ),

                  GridTile(
                    child: Text("Appointment"),

                  ),

                  GridTile(
                    child: Text("Appointment"),

                  ),

                  GridTile(
                    child: Text("Appointment"),

                  )







                ],
              ),*/

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(

                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Appointments"),
                      ),
                    ),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(
                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Doctors"),
                      ),
                    ),
                  ),
                )



              ],
            ),



            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(

                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Vital Sign & BMI"),
                      ),
                    ),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(
                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Prescriptions"),
                      ),
                    ),
                  ),
                )



              ],
            ),

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(

                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("History"),
                      ),
                    ),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(
                    onTap: (){

                    },
                    child: Container(
                      height: 100,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Report"),
                      ),
                    ),
                  ),
                )



              ],
            ),










          ],
        )

      ),
    );
  }
}

class Login_page extends StatelessWidget
{
  TextEditingController emailController=TextEditingController();
  TextEditingController passwordController=TextEditingController();

  void logIn(String Email, String Password) async
  {
    try{
      Response response=await post(Uri.parse(""),
      body: {
        "email" : Email,
        "password" : Password

      }
      );

    }catch(e)
    {

    }

  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextFormField(
              controller: emailController,
              decoration: InputDecoration(
                hintText: "Email",
              ),
            ),

            TextFormField(
              controller: passwordController,
              decoration: InputDecoration(
                hintText: "Password",
              ),
            ),

            GestureDetector(
              onTap: (){
                logIn(emailController.text.toString(),passwordController.text.toString());
              },
              child: Container(
                height: 50,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10),
                  color: Colors.green

                ),
                child: Center(
                  child: Text("Signin"),
                ),
              ),
            )



          ],
        ),
      ),
    );
  }
  
}


class Sign_upPage extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [

            TextFormField(
              decoration: InputDecoration(
                hintText: "Name"
              ),
            ),

            TextFormField(
              decoration: InputDecoration(
                  hintText: "Email"
              ),
            ),

            TextFormField(
              decoration: InputDecoration(
                  hintText: "password"
              ),
            ),

            GestureDetector(
              onTap: (){

              },
              child: Container(
                height: 50,
                decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(10),
                    color: Colors.green

                ),
                child: Center(
                  child: Text("Signup"),
                ),
              ),
            )

          ],
        ),
      ),
    );
  }

}

class Patient_profile extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [


                Container(
                  alignment: Alignment.centerLeft,
                  child: Image.asset('image/logo.png'),
                ),

                Container(
                  child: Text("User name"),
                  alignment: Alignment.center,
                ),


              ],
            )


          ],
        ),
      ),
    );
  }

}
