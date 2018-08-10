package katas;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    public static List<Map<String, Object>> execute() {
        List<Map<String, Object>> lists = DataUtil.getLists();
        List<Map<String, Object>> videos = DataUtil.getVideos();
        List<Map<String, Object>> boxArts = DataUtil.getBoxArts();
        List<Map<String, Object>> bookmarkList = DataUtil.getBookmarkList();
        
        return lists.stream()
            	.map(list -> {
            		Map<String, Object> myMap = new HashMap<>();
        			myMap.put("name", list.get("name").toString());
        			myMap.put("videos", videos.stream()
        	        					.filter(video -> (int) video.get("listId") == (int) list.get("id"))
        	        					.map(choosedVideo -> {
        	        						Map<String, Object> myMap2 = new HashMap<>();
        	        						int id = (int) choosedVideo.get("id");
        	        						myMap2.put("id", id);
        	        						myMap2.put("title", choosedVideo.get("title"));
        	        						myMap2.put("time", bookmarkList.stream()
        	        											.filter(bookmark -> (int) bookmark.get("videoId") == id)
        	        											.map(choosedBookmark -> choosedVideo.get("title"))
        	        											.collect(toList()));
        	        						myMap2.put("boxart", boxArts.stream()
        											.filter(boxart -> (int) boxart.get("videoId") == id)
        											.limit(1)
        											.map(choosedBoxart -> choosedBoxart.get("url"))
        											.collect(toList()));
        	        						return myMap2;
        	        					})
        	        					.collect(toList()));
        			
            		return myMap;
            	})        	
            	.collect(toList());
    }
}
