

import 'dart:convert';

import 'package:brain_station_test/Event_Detail.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:intl/intl.dart';

String bdy="";

class Event_Detail extends StatefulWidget
{

  //const Event_Detail({Key? key}) : super(key: key);

  List<dynamic>? list,bdy;
  int index;


  Event_Detail(this.list, this.index);

  /////////////////////////////////////////////



  //////////////////////////////////////





  @override
  State<Event_Detail> createState() => _Event_DetailState(list,index);
}







class _Event_DetailState extends State<Event_Detail>//StatelessWidget
{
  List<dynamic>? list;
  int index;
  //SharedPreferences sharedPreferences;//= SharedPreferences.getInstance();

/////////////////////////////////////////////////////////////

  Future getuserData() async
  {
    var response=await http.get(
        Uri.parse(list![index]['repo']['url'].toString())
    );

    bdy=response.body.toString();
    //bdy=jsonDecode(response.body);
     SharedPreferences sharedPreferences=await SharedPreferences.getInstance();
    sharedPreferences.setString(index.toString(),bdy);

  }


  _Event_DetailState(this.list, this.index);


   Load() async
  {
    SharedPreferences sP= await SharedPreferences.getInstance();

    return sP.getString(index.toString());
  }



  String date(String date)
  {

    DateTime dt = DateTime.parse(date);
    return DateFormat('dd-MM-yy').format(dt);
  }

  String tme(String date)
  {

    DateTime dt = DateTime.parse(date);
    return DateFormat('kk:mm').format(dt);
  }





  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
        body: SingleChildScrollView(
        child:Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [

            Row(
              children: [




                Padding(padding: const EdgeInsets.all(8.0),

                  child:Container(
                    child: Image.network(list![index]['actor']['avatar_url'].toString(),
                      width: 100,
                      height: 100,
                    ),
                  ),


                ),

                Column(
                  children: [

                    //Text( "Event ID: "+list![index]['id'].toString()),
                    Text( "Actor ID: "+list![index]['actor']['id'].toString()),
                    Text( "Repo ID: "+list![index]['repo']['id'].toString()),


                    
                  ],




                )


              ],
            ),



            Text( "Repo URL: "+list![index]['repo']['url'].toString()),

            Text( "Repo owner: "+list![index]['repo']['name'].toString()),
            Text( "Last Update: "+list![index]['updated_at'].toString()),

            //Text( "Created at: "+list![index]['created_at'].toString()),//DateFormat("yyyy-MM-dd hh:mm:ss").format(DateTime.now());

            Text( "Created at: "+date(list![index]['created_at'].toString())),
            Text( "Time: "+tme(list![index]['created_at'].toString())),

            Text( "Repository detail: "+bdy),



            ///////////////////////////////////////////////////



            //////////////////////////////////////////////////////////






          ],
        ),

      )

      ),
    );




  }

  @override
  void initState() {
    getuserData();

    super.initState();

  }
}

