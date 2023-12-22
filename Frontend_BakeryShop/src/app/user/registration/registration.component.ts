import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'tiff-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {
  user = {
    username: '',
    email: '',
    password: ''
  };

  onSubmit() {
    console.log('User Registration Data:', this.user);
    // You can send the user registration data to your backend or perform other actions here.
  }
}
