package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
	public static List<Map<String, Object>> execute() {
        List<Map<String, Object>> lists = DataUtil.getLists();
        List<Map<String, Object>> videos = DataUtil.getVideos();
              
        return lists.stream()
        	.map(list -> {
        		Map<String, Object> myMap = new HashMap<>();
    			myMap.put("name", list.get("name").toString());
    			myMap.put("videos", videos.stream()
    	        					.filter(video -> (int) video.get("listId") == (int) list.get("id"))            	    	
    	        					.collect(toList()));
    			
        		return myMap;
        	})        	
        	.collect(toList());           
    }
}
