//
//  LoginView.swift
//  app
//
//  Created by Longkun on 2022/12/12.
//

import SwiftUI

struct LoginView: View {
    
    @ObservedObject var loginUserInfoViewModel = LoginViewModel()
    
    @Binding var loginSuccess: Bool
    
    @State var showErrorMsg: Bool = false
        
    var body: some View {
        NavigationView {
            Form {
                Section(header: Text("uid和密码")) {
                    HStack {
                        Image(systemName: "person.fill")
                        TextField("UID，不是用户名", text: $loginUserInfoViewModel.userInfo.uid)
                            .disableAutocorrection(true)
                    }
                    HStack {
                        Image(systemName: "lock.fill")
                        TextField("登录密码", text: $loginUserInfoViewModel.userInfo.password)
                            .disableAutocorrection(true)
                    }
                    if showErrorMsg {
                        Text("用户名或密码错误")
                            .foregroundColor(Color.pink)
                            .font(.system(size: 13))
                            .opacity(0.8)
                    }
                }
                HStack {
                    Button("登录", action: {
                        self.loginUserInfoViewModel.login()
                        self.loginSuccess = self.loginUserInfoViewModel.loginSuccess
                        showErrorMsg = !self.loginUserInfoViewModel.loginSuccess
                    })
                    .frame(maxWidth: .infinity, maxHeight: .leastNormalMagnitude, alignment: .center)
                }
                Section {
                    NavigationLink(destination: RegisterView().navigationBarTitle(Text("注册"), displayMode: .inline)) {
                        Text("注册")
                    }
                }
            }.navigationTitle(Text("登录"))
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView(loginSuccess: .constant(true))
    }
}
