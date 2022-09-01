
import 'dart:async';
import 'dart:convert';

import 'package:brain_station_test/Event_Detail.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';








class Event_List extends StatefulWidget
{
  const Event_List({Key? key}) : super(key: key);

  @override
  State<Event_List> createState() => _Event_ListState();
}

class _Event_ListState extends State<Event_List> {

  // Timer.periodic(Duration(seconds: 1), (timer) {
  //
  // });




Map <String,dynamic>? sharedPreferenceMap;






  Map <String, dynamic>? apiMap;
  List<dynamic>? list;

  Future getUserData() async
  {
    var response=await http.get(
        Uri.parse('https://api.github.com/events')
    );

    setState((){
      list = jsonDecode(response.body);
     // list=list?..sort((a,b)=>a['id'].compareTo(b['id']));    [index]['created_at'].toString()
      list=list?..sort((a,b)=>a['created_at'].compareTo(b['created_at']));

    });

    print(list?.length);



  }


  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(

        appBar: AppBar(

          title: Text("List of Repository"),

        ),

          body: Card(
            child:
            ListView.builder(
                itemCount: list?.length,
                itemBuilder: (_HomeState, index){

                 //list?.sort((a, b) => a.compareTo(b));

                  Timer.periodic(Duration(seconds: 1800), (timer){

                    setState(() {});

                  },);

                  //return List_View_Tile(textData: list![index]['actor']['id'].toString());


                  return ListTile(
                    leading: Image.network(list![index]['actor']['avatar_url'].toString()),
                    title: Text( "Repository ID: "+list![index]['repo']['id'].toString()),//list![index]['actor']['id'].toString()),
                    subtitle: Text("Repository name : "+list![index]['repo']['name'].toString()),

                    onTap: (){

                      // String actorID=list![index]['actor']['id'].toString();
                      // String actorLogin=list![index]['actor']['login'].toString();
                      // String actor=list![index]['actor']['id'].toString();

                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) =>
                                  Event_Detail(list,index)));




                    },





                  );

                  //Text(list![index]['id']);
                }
            ),
          )


      ),
    );
  }

  @override
  void initState() {

    getUserData();

    super.initState();


  }
}

class User{

  final String name,email,username;

  User(this.name, this.email, this.username);
}

