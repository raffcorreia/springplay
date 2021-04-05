import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
    @Input() id = '';
    @Input() title: string = "Login";
    @Input() defaultUsername: string = "";
    @Input() defaultPassword: string = "";
    @Output() submitLogin: EventEmitter<{ userName: string, password: string }> = new EventEmitter();

    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    loginSuccessful: boolean = null;

    constructor(
        private formBuilder: FormBuilder,
    ) {
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        this.formControls.username.setValue(this.defaultUsername);
        this.formControls.password.setValue(this.defaultPassword);
    }

    get formControls() {
        return this.loginForm.controls;
    }

    doLogin() {
        this.loading = true;
        this.submitted = true;

        if (this.loginForm.invalid) {
            return;
        }

        this.submitLogin.emit({
            userName:this.formControls.username.value,
            password:this.formControls.password.value
        });
    }

    loginResult(isSuccess: boolean) {
        this.loading = false;
        this.loginSuccessful = isSuccess;
    }

}
