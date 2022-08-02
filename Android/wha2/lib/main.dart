

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

//import 'package:http/http.dart';


void main()
{
  //runApp(Doctor_Dash_Board());
  //runApp(Home());
  //runApp(Welcome_page());
  runApp(DashBoard());
  //runApp(Doctor_Dash_Board());
  //runApp(Doctor_Dash_Board());


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
      home: Builder(
        builder: (context) {
          return Scaffold(
              body: SingleChildScrollView(
                child: Column(


                  children: [



                    Container(
                      height: 300,

                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Row(

                        children: [

                          Padding(
                            padding: const EdgeInsets.all(20),
                            child: CircleAvatar(

                              backgroundImage: AssetImage("image/person.jpg"),
                              radius: 50,

                            ),
                          ),

                          Container(
                            child: Text("Patient's name",
                              style: TextStyle(fontSize: 30),),
                          ),

                          Container(
                            child: Center(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.center,
                                children: [

                                  Padding(
                                    padding: const EdgeInsets.fromLTRB(0, 70, 0, 70),
                                    child: Image.asset('image/call.jpg'),
                                  ),
                                  Image.asset('image/call cut.jpg')

                                ],
                              ),
                            ),
                          )


                        ],

                      ),
                    ),


                    Container(

                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,

                        children: [

                          Center(
                            child: Row(

                              children: [

                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: GestureDetector(

                                    onTap: (){

                                      //Appointment();
                                      Navigator.push(
                                          context,
                                          MaterialPageRoute(
                                              builder: (context) =>
                                                  Appointment()));




                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(10),
                                          color: Colors.green

                                      ),
                                      child: Center(
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.assignment_ind),
                                            ),
                                            Text("Apointment"),
                                          ],
                                        ), //Center(child: Text("Apointment")),
                                      ),
                                    ),
                                  ),
                                ),


                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: GestureDetector(

                                    onTap: (){

                                      //Choose_a_doctor();
                                      Navigator.push(
                                          context,
                                          MaterialPageRoute(
                                              builder: (context) =>
                                                  Choose_a_doctor()));



                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(10),
                                          color: Colors.green

                                      ),
                                      child: Center(
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.person_outline_outlined),
                                            ),
                                            Text("Doctor"),
                                          ],
                                        ),  //Text("Doctor"),
                                      ),
                                    ),
                                  ),
                                ),




                              ],
                            ),






                          ),





                          Center(
                            child: Row(

                              children: [

                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: GestureDetector(

                                    onTap: (){


                                     // Vital_sign();

                                      Navigator.push(
                                          context,
                                          MaterialPageRoute(
                                              builder: (context) =>
                                                  Vital_sign()));


                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(10),
                                          color: Colors.green

                                      ),
                                      child: Center(
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.recycling),
                                            ),
                                            Text("Vital Sign\n& BMI"),
                                          ],
                                        ),  //Text("Vital Sign\n&BMI"),
                                      ),
                                    ),
                                  ),
                                ),


                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: GestureDetector(

                                    onTap: (){

                                      Navigator.push(
                                          context,
                                          MaterialPageRoute(
                                              builder: (context) =>
                                      Prescription()));




                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(10),
                                          color: Colors.green

                                      ),
                                      child: Center(
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.assignment_outlined),
                                            ),
                                            Text("prescription"),
                                          ],
                                        ), //Text("Prescribtion"),
                                      ),
                                    ),
                                  ),
                                ),




                              ],
                            ),
                          ),


                          Center(
                              child: Row(

                                children: [

                                  Padding(
                                    padding: const EdgeInsets.all(20),
                                    child: GestureDetector(

                                      onTap: (){

                                        /*Navigator.push(
                                            context,
                                            MaterialPageRoute(
                                                builder: (context) =>
                                                    ()));*/


                                      },
                                      child: Container(
                                        height: 100,
                                        width: 100,
                                        decoration: BoxDecoration(
                                            borderRadius: BorderRadius.circular(10),
                                            color: Colors.green

                                        ),
                                        child: Center(
                                          child: Column(
                                            crossAxisAlignment: CrossAxisAlignment.center,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.all(20),
                                                child: Icon(Icons.assignment_outlined),
                                              ),
                                              Text("history"),
                                            ],
                                          ),  //Text("History"),
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
                                          child: Column(
                                            crossAxisAlignment: CrossAxisAlignment.center,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.all(20),
                                                child: Icon(Icons.assignment_outlined),
                                              ),
                                              Text("Report"),
                                            ],
                                          ),
                                        ),
                                      ),
                                    ),
                                  ),




                                ],
                              )
                          ),




                          Center(
                              child: Row(

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
                                          child: Column(
                                            crossAxisAlignment: CrossAxisAlignment.center,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.all(20),
                                                child: Icon(Icons.cases),
                                              ),
                                              Text("Packages"),
                                            ],
                                          ),
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
                                          child:Column(
                                            crossAxisAlignment: CrossAxisAlignment.center,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.all(20),
                                                child: Icon(Icons.confirmation_num_outlined),
                                              ),
                                              Text("Nearest\nPharmacy"),
                                            ],
                                          ), //Text("Nearest\nPharmacy"),
                                        ),
                                      ),
                                    ),
                                  ),




                                ],
                              )
                          ),


                          Center(
                            child: Row(

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
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.book_outlined),
                                            ),
                                            Text("Medical guide"),
                                          ],
                                        ), //Text("Medical Guide"),
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
                                        child:Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.compare),
                                            ),
                                            Text("Compare"),
                                          ],
                                        ),  //Center(child: Text("Compare")),
                                      ),
                                    ),
                                  ),
                                ),




                              ],
                            ),
                          ),



                          Center(
                            child: Row(

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
                                        child: Column(
                                          crossAxisAlignment: CrossAxisAlignment.center,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.all(20),
                                              child: Icon(Icons.local_hospital),
                                            ),
                                            Text("Triage"),
                                          ],
                                        ), //Text("Triage"),
                                      ),
                                    ),
                                  ),
                                ),


                               /* Padding(
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
                                        child: Center(child: Text("")),
                                      ),
                                    ),
                                  ),
                                ),*/




                              ],
                            ),
                          )











                        ],

                      ),



                    )







                  ],



                ),
              )
          );
        }
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
      /*Response response=await post(Uri.parse(""),
          body: {
            "email" : Email,
            "password" : Password

          }
      );*/

    }catch(e)
    {

    }

  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Padding(
                padding: const EdgeInsets.all(20),
                child: TextFormField(
                  controller: emailController,
                  decoration: InputDecoration(
                    hintText: "Email",
                  ),
                ),
              ),

              Padding(
                padding: const EdgeInsets.all(20),
                child: TextFormField(
                  controller: passwordController,
                  decoration: InputDecoration(
                    hintText: "Password",
                  ),
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


class EditProfile extends StatefulWidget
{
  @override
  State<EditProfile> createState() => _EditProfileState();
}

class _EditProfileState extends State<EditProfile> {
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: "Edit profile",
      home: Scaffold(
        body: Column(
          children: [

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                  hintText: "Name"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Phone number"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Age"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Height"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "weight"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Address"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Password"
                ),
              ),
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
                      height: 50,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Text("Save"),
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
                      height: 50,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(10),
                          color: Colors.red

                      ),
                      child: Center(
                        child: Text("Cancel"),
                      ),
                    ),
                  ),
                )



              ],
            )











          ],
        ),
      ),
    );
  }
}

class Choose_a_health_Concern extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      title: "Choose a health Concern",
      home: Scaffold(

        body: Center(
          child: GridView.count(

              crossAxisCount: 2,
            children: [

          GridTile(

          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: GestureDetector(

              child: Container(
                decoration: BoxDecoration(
                  color: Colors.green,
                  borderRadius: BorderRadius.circular(10),
                ),


                child: Center(child: Text("General physicist")),
      ),
            ),
          )
          ),

          GridTile(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: GestureDetector(
                      child: Container(
                        decoration: BoxDecoration(
                          color: Colors.green,
                          borderRadius: BorderRadius.circular(10),
                        ),

                        child: Center(
                            child: Text("Nurology")
                        ),
                      ),
                    ),
                  ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10),
                      ),

                      child: Center(child: Text("orthopedic Sergon")),
                    ),
                  ),
                ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10),
                      ),

                      child: Center(child: Text("nutretionist")),
                    ),
                  ),
                ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10),
                      ),

                      child: Center(child: Text("Anesthisiologist")),
                    ),
                  ),
                ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      color: Colors.green,
                      borderRadius: BorderRadius.circular(10),
                    ),

                    child: Center(child: Text("Skin Diseas")),
                  ),
                ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: Container(
                      //color: Colors.green,
                      decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10),
                      ),

                      child: Center(child: Text("General surgery")),
                    ),
                  ),
                ),
              ),

              GridTile(
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GestureDetector(
                    child: Container(

                      decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                      ),
                      child: Center(child: Text("plastic surgery")),
                    ),
                  ),
                ),
              ),







            ],

          ),
        ),

      ),
    );
  }

}

class Choose_a_doctor extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      title: " Choose a doctor",
      home: Scaffold(

        body: GridView.count(
            crossAxisCount: 2,
          children: [

            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(child: Text("Dr. Nafim Ahmed")),
                  ),
                ),
              ),
            ),

            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(child: Text("Dr. Trinath Saha")),
                  ),
                ),
              ),
            ),

            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(child: Text("Dr. Khademul Islam")),
                  ),
                ),
              ),
            ),

            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(child: Text("Dr. Abul kalam Azad")),
                  ),
                ),
              ),
            ),

            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(child: Text("plastic surgery")),
                  ),
                ),
              ),
            ),


            GridTile(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.green,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Center(
                        child: Text("Dr.etc")
                    ),
                  ),
                ),
              ),
            ),







          ],

        ),

      ),
    );
  }

}

class DoctorDetail extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          
          children: [
            
            CircleAvatar(

              backgroundImage: AssetImage("image/person.jpg"),
              radius: 100,

            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: Center(
                child: Container(
                  child: Text("Dr. Nafim Ahmed\n MBBS., FCPS."),
                ),
              ),
            ),


            GestureDetector(
              onTap: (){
                //logIn(emailController.text.toString(),passwordController.text.toString());
              },
              child: Container(
                height: 50,
                width: 200,
                decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(10),
                    color: Colors.green

                ),
                child: Center(
                  child: Text("Get appointment"),
                ),
              ),
            )




          ],
          
        ),
      ),
    );
  }

}


class Appointment extends StatefulWidget{
  @override
  State<Appointment> createState() => _AppointmentState();
}

class _AppointmentState extends State<Appointment> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(

      home: Scaffold(
        body: Column(

          children: [

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Get Emargrcy Appointment"),
                  ),
                ),
              ),
            ),

            GestureDetector(

              onTap: (){

              },
              child: Container(
                height: 200,

                decoration: BoxDecoration(
                    //borderRadius: BorderRadius.circular(10),
                    color: Colors.green

                ),
                child: Center(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,

                    children: [

                      CircleAvatar(

                        backgroundImage: AssetImage("image/clock.jpg"),
                        radius: 50,

                      ),

                      Padding(
                        padding: const EdgeInsets.all(20),
                        child: Container(
                          child: Text("Date and time",
                          style: TextStyle(
                            fontSize: 50,
                          ),
                          ),
                        ),
                      )





                    ],


                  ) ,
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Confirm Appointment"),
                  ),
                ),
              ),
            ),





          ],

        ),
      ),

    );
  }
}


class Vital_sign extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("See All vital Sign"),
                  ),
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("See BMI"),
                  ),
                ),
              ),
            ),



            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Add vital Sign"),
                  ),
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Add BMI"),
                  ),
                ),
              ),
            ),






          ],
        ),
      ),
    );
  }

}

class Add_vital_sign extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(

          children: [

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Enter vital type"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Enter vital value"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Date"
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Confirm Your vital Sign"),
                  ),
                ),
              ),
            ),







          ],


        ),
      ),
    );
  }

}



class Add_BMI extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(

          children: [

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Height"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Weight"
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(10),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Date"
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Confirm Your BMI"),
                  ),
                ),
              ),
            ),







          ],


        ),
      ),
    );
  }

}

class Vital_Sign_List extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Scaffold(

        body: ListView(
          children: [

            ListTile(
              leading: const Icon(Icons.access_alarm),
              title: const Text("Vital Sign Name"),
              subtitle: const Text("Vital Sign type"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.access_alarm),
              title: const Text("Vital Sign Name"),
              subtitle: const Text("Vital Sign type"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.access_alarm),
              title: const Text("Vital Sign Name"),
              subtitle: const Text("Vital Sign type"),
              selected: false,
              onTap: (){

              },

            )





          ],
        ),

      ),

    );
  }

}

class Prescription extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(

          children: [

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("All prescription list"),
                  ),
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Special prescription"),
                  ),
                ),
              ),
            ),





          ],

        ),
      ),
    );
  }
  
}

class Prescription_list extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Scaffold(

        body: ListView(
          children: [

            ListTile(
              leading: const Icon(Icons.account_circle_outlined),
              title: const Text("Disease name"),
              subtitle: const Text("physicist name"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.account_circle_outlined),
              title: const Text("Disease name"),
              subtitle: const Text("physicist name"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.account_circle_outlined),
              title: const Text("Disease name"),
              subtitle: const Text("physicist name"),
              selected: false,
              onTap: (){

              },

            )





          ],
        ),

      ),

    );
  }

}


class Report extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [

            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("All previous report"),
                  ),
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("Add report"),
                  ),
                ),
              ),
            ),





          ],
        ),
      ),
    );
  }

}

class All_previous_report extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: ListView(

          children: [

            ListTile(
              leading: const Icon(Icons.accessibility_outlined),
              title: const Text("X-Ray"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.bloodtype),
              title: const Text("ESR"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.blur_off_outlined),
              title: const Text("CBC"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: const Icon(Icons.adf_scanner),
              title: const Text("CT scan"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),



            ListTile(
              leading: const Icon(Icons.document_scanner),
              title: const Text("MRI"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),



            ListTile(
              leading: const Icon(Icons.blur_on_outlined),
              title: const Text("Blood culture"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),


            ListTile(
              leading: const Icon(Icons.brightness_low_outlined),
              title: const Text("Urine Culture"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),


            ListTile(
              leading: const Icon(Icons.bloodtype_outlined),
              title: const Text("S Uric Acid"),
              subtitle: const Text(""),
              selected: false,
              onTap: (){

              },

            ),



          ],

        )
      ),
    );
  }

}

class Report_Description extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(

      home: Scaffold(
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [

            Center(
              child: ClipRRect(

                borderRadius: BorderRadius.all(Radius.circular(10.0)),//add border radius here
                child: Container(
                  height: 300,
                    width: 300,
                    child: Image.asset('image/person.jpg')
                ),//add image location here
              ),
            ),

           /* CircleAvatar(

              backgroundImage: AssetImage("image/person.jpg"),
              radius: 100,

            ),*/




            Padding(
              padding: const EdgeInsets.all(20),
              child: GestureDetector(
                onTap: (){
                  //logIn(emailController.text.toString(),passwordController.text.toString());
                },
                child: Container(
                  height: 50,
                  width: 100,
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(10),
                      color: Colors.green

                  ),
                  child: Center(
                    child: Text("update Report"),
                  ),
                ),
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Container(
                child: Text("Report detail"),
              ),
            )




          ],
        ),
      ),

    );
  }

}


class Nearest_pharmacy extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: ListView(

          children: [

            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/person.jpg"),
                radius: 20,


              ),
              title: const Text("KolaBagan Pharmacy"),
              subtitle: const Text("Address------"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/person.jpg"),
                radius: 20,


              ),
              title: const Text("Shotota Pharmacy"),
              subtitle: const Text("Address------"),
              selected: false,
              onTap: (){

              },

            ),

            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/person.jpg"),
                radius: 20,


              ),
              title: const Text("Uttara Pharmacy"),
              subtitle: const Text("Address------"),
              selected: false,

              onTap: (){

              },

            ),




          ],

        ),
      ),
    );
  }
  
}

class Nearest_Doctor extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: GridView.count(
          crossAxisCount: 2,

        children: [

          GridTile(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GestureDetector(
                child: Container(

                  decoration: BoxDecoration(
                      color: Colors.cyanAccent,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child: Column(
                    children: [

                      CircleAvatar(
                        backgroundImage: AssetImage("image/person.jpg"),
                        radius: 50,
                      ),

                      Center(child: Text("Dr. Nafim Ahmed")),

                      Center(child: Text(
                        "Doctor's Details",
                      style: TextStyle(fontSize: 20),
                      )),
                    ],
                  ),
                ),
              ),
            ),
          ),


          GridTile(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GestureDetector(
                child: Container(

                  decoration: BoxDecoration(
                      color: Colors.cyanAccent,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child: Column(
                    children: [

                      CircleAvatar(
                        backgroundImage: AssetImage("image/person.jpg"),
                        radius: 50,
                      ),

                      Center(child: Text("Dr. Nafim Ahmed")),

                      Center(child: Text(
                        "Doctor's Details",
                        style: TextStyle(fontSize: 20),
                      )),
                    ],
                  ),
                ),
              ),
            ),
          ),


          GridTile(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GestureDetector(
                child: Container(

                  decoration: BoxDecoration(
                      color: Colors.cyanAccent,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child: Column(
                    children: [

                      CircleAvatar(
                        backgroundImage: AssetImage("image/person.jpg"),
                        radius: 50,
                      ),

                      Center(child: Text("Dr. Nafim Ahmed")),

                      Center(child: Text(
                        "Doctor's Details",
                        style: TextStyle(fontSize: 20),
                      )),
                    ],
                  ),
                ),
              ),
            ),
          ),



          GridTile(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GestureDetector(
                child: Container(

                  decoration: BoxDecoration(
                      color: Colors.cyanAccent,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child: Column(
                    children: [

                      CircleAvatar(
                        backgroundImage: AssetImage("image/person.jpg"),
                        radius: 50,
                      ),

                      Center(child: Text("Dr. Nafim Ahmed")),

                      Center(child: Text(
                        "Doctor's Details",
                        style: TextStyle(fontSize: 20),
                      )),
                    ],
                  ),
                ),
              ),
            ),
          ),


          GridTile(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GestureDetector(
                child: Container(

                  decoration: BoxDecoration(
                      color: Colors.cyanAccent,
                      borderRadius: BorderRadius.circular(10)
                  ),
                  child: Column(
                    children: [

                      CircleAvatar(
                        backgroundImage: AssetImage("image/person.jpg"),
                        radius: 50,
                      ),

                      Center(child: Text("Dr. Nafim Ahmed")),

                      Center(child: Text(
                        "Doctor's Details",
                        style: TextStyle(fontSize: 20),
                      )),
                    ],
                  ),
                ),
              ),
            ),
          ),






        ],

      ),
    );
  }

}

class Nearest_doctor_detail extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {

    return MaterialApp();
  }
  
}

class Nearest_Triage_List extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        body: ListView(

          children: [

            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/hospital.jpg"),
                radius: 20,


              ),
              title: const Text("Lab Aid"),
              subtitle: const Text("Address------"),
              selected: false,

              onTap: (){

              },

            ),


            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/hospital.jpg"),
                radius: 20,


              ),
              title: const Text("Lab Aid"),
              subtitle: const Text("Address------"),
              selected: false,

              onTap: (){

              },

            ),

            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/hospital.jpg"),
                radius: 20,


              ),
              title: const Text("Lab Aid"),
              subtitle: const Text("Address------"),
              selected: false,

              onTap: (){

              },

            ),


            ListTile(
              leading: CircleAvatar(
                backgroundImage: AssetImage("image/hospital.jpg"),
                radius: 20,


              ),
              title: const Text("Lab Aid"),
              subtitle: const Text("Address------"),
              selected: false,

              onTap: (){

              },

            ),





          ],




        ) ,
      ),
    );
  }
  
}


class Doctor_Dash_Board extends StatefulWidget
{
  @override
  State<Doctor_Dash_Board> createState() => _Doctor_Dash_BoardState();
}

class _Doctor_Dash_BoardState extends State<Doctor_Dash_Board> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: SingleChildScrollView(
          child: Column(


          children: [



            Container(
              height: 300,

              decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10),
                  color: Colors.green

              ),
              child: Row(

                children: [

                  Padding(
                    padding: const EdgeInsets.all(20),
                    child: CircleAvatar(

                      backgroundImage: AssetImage("image/person.jpg"),
                      radius: 50,

                    ),
                  ),

                  Container(
                    child: Text("Doctor's Name",
                      style: TextStyle(fontSize: 30),),
                  )


                ],

              ),
            ),


            Container(

              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                 crossAxisAlignment: CrossAxisAlignment.center,

                 children: [

                   Center(
                     child: Row(

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
                                 child: Center(child: Text("Request")),
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
                                 child: Text("Appointments"),
                               ),
                             ),
                           ),
                         ),




                       ],
                     ),






                   ),





      Center(
        child: Row(

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
                    child: Text("Prescriptions"),
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
                    child: Text("Patients"),
                  ),
                ),
              ),
            ),




          ],
        ),
      ),


      Center(
        child: Row(

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
                    child: Text("Duty info"),
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
                    child: Text("Payment\ninfo"),
                  ),
                ),
              ),
            ),




          ],
        )
      ),


      Center(
        child: Row(

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
                    child: Text("Nurses"),
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
                    child: Text("Nearest\nPharmacy"),
                  ),
                ),
              ),
            ),




          ],
        )
      ),


      Center(
        child: Row(

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
                    child: Text("Nearest\ntriage"),
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
                    child: Center(child: Text("Nearest\n hospital")),
                  ),
                ),
              ),
            ),




          ],
        ),
      )









        ],

              ),



            )







          ],



        ),
      )
    ),
    );
  }
}



class Request_List extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Scaffold(
        body: ListView(
          children: [

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),
              title: Text("patient name"),
              subtitle: Text("Request time :"),
            ),


            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),
              title: Text("patient name"),
              subtitle: Text("Request time :"),
            ),


            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),
              title: Text("patient name"),
              subtitle: Text("Request time :"),
            )



          ],
        )
      )

    );
  }

}

class Appointment_request_detail extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(

            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,

            children: [

              CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  child: Text("patient name : "+"Rafi chowdhuri"),
                ),
              ),

              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  child: Text("Requested by : "+"Rafi chowdhuri"),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  child: Text("Request time :  "+"12/12/2022, 8:20am"),
                ),
              ),

              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  child: Text("patient age : "+"24"),
                ),
              ),

              Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [

                  Padding(
                    padding: const EdgeInsets.all(20),
                    child: GestureDetector(

                      onTap: (){

                      },
                      child: Container(
                        height: 40,
                        width: 100,
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(20),
                            color: Colors.green

                        ),
                        child: Center(
                          child: Center(child: Text("Accept")),
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
                        height: 40,
                        width: 100,
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(20),
                            color: Colors.red

                        ),
                        child: Center(
                          child: Center(child: Text("Reject")),
                        ),
                      ),
                    ),
                  ),



                ],
              )



            ],



          ),
        ),
      ),
    );
  }

}


class Appointment_list extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Appointment list"),
        ),
        body: ListView(
          children: [

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),


            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            ),

            ListTile(
              leading: CircleAvatar(

                backgroundImage: AssetImage("image/person.jpg"),
                radius: 50,

              ),

              title: Text("patient name"),

              subtitle: Text("Request time"),


            )








          ],



        ),
      ),
    );
  }
  
}


class Appointment_Detail extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Scaffold(
        appBar: AppBar(
          title: Text("Appointment detail") ,
        ),
        body: SingleChildScrollView(
          child: Center(
            child: Column(

              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [


                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: CircleAvatar(

                      backgroundImage: AssetImage("image/person.jpg"),
                      radius: 50,

                    ),
                  ),



                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    child: Text("Patient name : "+"Rafi"),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    child: Text("Request by : "+"Rafi"),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    child: Text("Request time : "+"23/10/22, 8:00pm"),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    child: Text("Patient Age : "+"24"),
                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: GestureDetector(

                    onTap: (){

                    },
                    child: Container(
                      height: 40,
                      width: 100,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(5),
                          color: Colors.green

                      ),
                      child: Center(
                        child: Center(child: Text("Patient Info:")),
                      ),
                    ),
                  ),
                ),



                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.more_time),
                                ),
                                Text("Reschedule"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.call),
                                ),
                                Text("Call now"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                ),


                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.checklist_rtl_outlined),
                                ),
                                Text("Appointment\nStatus"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.assignment_outlined),
                                ),
                                Text("Prescribe"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                ),

                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.coronavirus),
                                ),
                                Text("Patient's\nComplain"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.note_alt_rounded),
                                ),
                                Text("Patient's Vital"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                ),

                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.device_thermostat),
                                ),
                                Text("Patient's Test\nReport"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.history_edu_sharp),
                                ),
                                Text("Patient's\nHistory"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                ),

                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.note_alt),
                                ),
                                Text("Add complain"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.note_add_sharp),
                                ),
                                Text("Add vitals"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                ),


                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.thermostat_auto),
                                ),
                                Text("Add report"),
                              ],
                            ), //Center(child: Text("Apointment")),
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
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.center,
                              children: [
                                Padding(
                                  padding: const EdgeInsets.all(20),
                                  child: Icon(Icons.history_edu),
                                ),
                                Text("Add history"),
                              ],
                            ), //Center(child: Text("Apointment")),
                          ),
                        ),
                      ),
                    )






                  ],
                )













              ],
            ),
          ),
        ),
      ),

    );
  }

}


class Patients_Previous_complain extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: ListView(

          children: [

            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                title: Container(
                    child: Column(
                      children: [
                        Text(
                          "Date : "+"02/01/2021",
                          style: TextStyle(
                              fontSize: 20,
                              fontWeight: FontWeight.bold
                          ),

                        ),

                        Text(
                          "Complain : "+"Back pain",

                        ),

                        Text(
                          "Comment : "+"eijwkewqkwekwqekdwed;efmmfelmfewmq",

                        ),



                      ],
                    )
                )
              ),
            ),

            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                  title: Container(
                      child: Column(
                        children: [
                          Text(
                            "Date : "+"02/01/2021",
                            style: TextStyle(
                                fontSize: 20,
                                fontWeight: FontWeight.bold
                            ),

                          ),

                          Text(
                            "Complain : "+"Back pain",

                          ),

                          Text(
                            "Comment : "+"eijwkewqkwekwqekdwed;efmmfelmfewmq",

                          ),


                          Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: ListTile(
                                title: Container(
                                    child: Column(
                                      children: [
                                        Text(
                                          "Date : "+"02/01/2021",
                                          style: TextStyle(
                                              fontSize: 20,
                                              fontWeight: FontWeight.bold
                                          ),

                                        ),

                                        Text(
                                          "Complain : "+"Back pain",

                                        ),

                                        Text(
                                          "Comment : "+"eijwkewqkwekwqekdwed;efmmfelmfewmq",

                                        ),



                                      ],
                                    )
                                )
                            ),
                          )



                        ],
                      )
                  )
              ),
            )

          ],



        ),

      ),
    );
  }

}


class All_Vital_Sign extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Scaffold(
        body: ListView(

          children: [

            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                title: Column(
                  children: [

                    Text(
                      "Date : "+"02/01/2021",
                      style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold
                      ),

                    ),

                    Text("Vital Sign Detail"),




                  ],
                ),

              ),
            ),

            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                title: Column(
                  children: [

                    Text(
                      "Date : "+"02/01/2021",
                      style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold
                      ),

                    ),

                    Text("Vital Sign Detail"),




                  ],
                ),

              ),
            ),


            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                title: Column(
                  children: [

                    Text(
                      "Date : "+"02/01/2021",
                      style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold
                      ),

                    ),

                    Text("Vital Sign Detail"),




                  ],
                ),

              ),
            )



          ],

        ),
      ),

    ) ;
  }

}


class Previous_Report extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: ListView(

          children: [

            ListTile(
              onTap: (){

              },

              leading: Image.asset('image/logo.png'),
              title: Text("X-Ray"),
              subtitle: Text("Description"),
            ),

            ListTile(
              onTap: (){

                //Navigator.push(context, route)

              },

              leading: Image.asset('image/logo.png'),
              title: Text("ESR"),
              subtitle: Text("Description"),
            ),

            ListTile(
              onTap: (){

              },

              leading: Image.asset('image/logo.png'),
              title: Text("CBC"),
              subtitle: Text("Description"),
            ),

            ListTile(
              onTap: (){



              },

              leading: Image.asset('image/logo.png'),
              title: Text("CT Scan"),
              subtitle: Text("Description"),
            )

          ],

        ),
      ),
    );
  }

}

class X_Ray_Page extends StatelessWidget
{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: SingleChildScrollView(
          child: Center(
            child: Column(
              children: [

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: new Image.asset("image/xray.jpg",
                    width: 300,
                    height: 400,
                    fit: BoxFit.cover,

                  ),
                ),

                Padding(
                  padding: const EdgeInsets.all(20),
                  child: Container(
                    child: Text(
                      "Description : ",
                      style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 25
                      ),
                    ),
                  ),
                ),


                Container(
                  child: Text(

                    "this is an XRay raport. In this report, we can see that......"

                  ),
                )

              ],
            ),
          ),
        )
      )
    );
  }
  
}

class Enter_your_complain extends StatefulWidget
{
  @override
  State<Enter_your_complain> createState() => _Enter_your_complainState();
}

class _Enter_your_complainState extends State<Enter_your_complain> {

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(

          mainAxisAlignment: MainAxisAlignment.center,


          children: [


            Center(
              child: Container(
                child:Center(

                  child: DropdownButton<String>(
                    items: <String>["Fever", "Migrain", "Cancer", "Back Pain"].map((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                    onChanged: (_) {





                    },
                  ),
                ),
              ),
            ),


            Padding(
              padding: const EdgeInsets.all(20),
              child: TextFormField(
                decoration: InputDecoration(
                    hintText: "Enter your comments"
                ),
              ),
            ),
          ],


        )
      )
    );
  }
}

class Prescribtion extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: Column(
          children: [




          ],
        ),
      )
    );
  }


}



