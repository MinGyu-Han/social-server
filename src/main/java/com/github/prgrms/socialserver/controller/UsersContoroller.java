package com.github.prgrms.socialserver.controller;

import com.github.prgrms.socialserver.domain.Users;
import com.github.prgrms.socialserver.dto.UserJoinDto;
import com.github.prgrms.socialserver.model.ResponseMessage;
import com.github.prgrms.socialserver.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersContoroller {
	@Autowired
	private UsersService usersService;

	@GetMapping()
	public ResponseEntity<List<Users>> getUsersInfo() throws Exception {
		List<Users> listUsers = usersService.findUsersAll();
		return new ResponseEntity<List<Users>> (listUsers, HttpStatus.OK);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<Users> getUserInfo(@PathVariable(name = "userid") Long userId) throws Exception {
		Users user = usersService.findUserById(userId);
		return new ResponseEntity<Users> (user, HttpStatus.OK);
	}
	
	@PostMapping("/join")
	public ResponseEntity<ResponseMessage> joinUser(@RequestBody UserJoinDto userJoinDto) throws Exception {
		try {
			Long seq = usersService.joinUser(userJoinDto);
			return new ResponseEntity<ResponseMessage> (new ResponseMessage(true
					, "가입완료"), HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<ResponseMessage> (new ResponseMessage(false
					, "가입실패"), HttpStatus.ACCEPTED);
		}
	}
}
