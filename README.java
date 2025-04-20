# hello-world
package com.example.demo.controller;

import com.example.demo.domain.Pages;
import com.example.demo.domain.Room;
import com.example.demo.domain.Room;
import com.example.demo.domain.Student;
import com.example.demo.service.AccService;
import com.example.demo.service.RoomService;
import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {
    @Resource
    private RoomService roomService;
    @Resource
    private AccService accService;

    @RequestMapping("/getroom")
    @ResponseBody
    public Result getRoom(){
        Result result = roomService.getAllRooms();
        return result;
    }

    @RequestMapping("/addroom")
    @ResponseBody
    public Result addRoom(@RequestBody Room room)
    {
        if (room.getDorId()==null)
        {
            return new Result(false,"宿舍号不能为空");
        }

        Result result = roomService.addRoom(room);
        return result;
    }

    @RequestMapping("/getroombyanyinfo")
    @ResponseBody
    public Result getRoombyanyinfo(@RequestBody Room room)
    {
        System.out.println("getRoombyanyinfo");
        System.out.println(room);
        Result result = roomService.getRoomByAnyInfo(room);
        return result;
    }

    @RequestMapping("/delroom")
    @ResponseBody
    public Result deleteRoom(@RequestBody Room room)
    {
        List<Room> rooms =new ArrayList<>();
        rooms.add(room);
        accService.deleteAccRoom(rooms);
        Result result = roomService.deleteRoomById(room);
        return result;
    }

    @PostMapping("/getallbuilding")
    @ResponseBody
    public Result getAllBuilding()
    {
        Result result = roomService.getAllBuilding();
        return result;
    }

    @PostMapping("/getroombybuilding")
    @ResponseBody
    public Result getRoomByBuilding(String building)
    {
        System.out.println("---------------------------------------"+building);
        Result result = roomService.getroombybuilding(building);
        return result;
    }

    @PostMapping("/getpageroom")
    @ResponseBody
    public Result getpageroom(@RequestBody Pages page)
    {
        Result result = roomService.getpageroom(page);
        return result;
    }

    @PostMapping("/editroom")
    @ResponseBody
    public Result editRoom(@RequestBody Room room)
    {
        Result result = roomService.updateRoomById(room);
        return result;
    }
}
