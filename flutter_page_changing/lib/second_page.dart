import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(

      home: Builder(
        builder: (context) {
          return Scaffold(

            body: Column(
              children: [

                GestureDetector(
                  onTap: (){
                    print("Tapped");



                  },
                  child: Container(

                    decoration: BoxDecoration(
                        color: Colors.red,
                        borderRadius: BorderRadius.circular(10)
                    ),
                    child: Column(
                      children: [

                        /*CircleAvatar(
                          backgroundImage: AssetImage("image/person.jpg"),
                          radius: 50,
                        ),*/

                        Center(child: Text("Dr. Nafim Ahmed")),

                        Center(child: Text(
                          "Doctor's Details",
                          style: TextStyle(fontSize: 20),
                        )),
                      ],
                    ),
                  ),
                ),

              ],
            ),
          );
        }
      ),

    );
  }


}