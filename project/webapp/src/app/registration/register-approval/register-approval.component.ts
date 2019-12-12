import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register-approval',
  templateUrl: './register-approval.component.html',
  styleUrls: ['./register-approval.component.css']
})
export class RegisterApprovalComponent implements OnInit {

  pendingUsers: any;
  isApproved: boolean;
  isDeclined: boolean;
  nullList: boolean;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.nullList = false;
    this.isApproved = false;
    this.userService.getAllPendingRequests().subscribe((response) => {
      console.log(response);
      this.pendingUsers = response;
      if(this.pendingUsers.length == 0){
        this.nullList =  true;
      }
    })
  }

  updatePendingList(){
    this.userService.getAllPendingRequests().subscribe((response) => {
      console.log(response);
      this.pendingUsers = response;
    })
  }
  approveUser(id){
    this.userService.approveUser(id).subscribe((response) =>{
      this.isApproved = true;
      this.updatePendingList();
    })
  }

  declineUser(id){
    this.userService.declineUser(id).subscribe((response) =>{
      this.isDeclined = true;
      this.updatePendingList();
    })
  }
}
