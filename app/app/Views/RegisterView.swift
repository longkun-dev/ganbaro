//
//  ContentView.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI

struct RegisterView: View {
    
    @ObservedObject var registerViewModel = RegisterViewModel()
    
    @State var usernameIsCorrect: Bool = true
    @State var passwordIsCorrect: Bool = true
    
    @State var showAlert: Bool = false
    
    var body: some View {
        Form {
            Section(header: Text("基本信息")) {
                HStack {
                    Image(systemName: "person.fill")
                    TextField("请输入用户名", text: $registerViewModel.userInfoModel.username)
                        .disableAutocorrection(true)
                    if !usernameIsCorrect {
                        Text("用户名至少5位")
                            .foregroundColor(.pink)
                            .font(.system(size: 13))
                            .opacity(0.8)
                    }
                }
                HStack {
                    Image(systemName: "lock.fill")
                    TextField("请输入密码", text: $registerViewModel.userInfoModel.password)
                        .disableAutocorrection(true)
                    if !passwordIsCorrect {
                        Text("密码至少8位")
                            .foregroundColor(.pink)
                            .font(.system(size: 13))
                            .opacity(0.8)
                    }
                }
            }
            Section(header: Text("性别")) {
                HStack {
                    Image(systemName: "sun.max.fill")
                    Picker(selection: self.$registerViewModel.userInfoModel.sex, label: Text("请选择性别")) {
                        Text("保密").tag("U")
                        Text("男").tag("M")
                        Text("女").tag("F")
                    }
                }
            }
            HStack {
                Button("注册", action: {
                    self.check()
                    
                    if (usernameIsCorrect && passwordIsCorrect) {
                        self.registerViewModel.submit(self.registerViewModel)
                        showAlert = true
                    }
                })
                .alert(isPresented: $showAlert) {
                    Alert(title: Text("提示"), message: self.registerViewModel.registerSuccess ? Text("注册成功") : Text("注册失败"))
                }
            }.frame(maxWidth: .infinity, maxHeight: .leastNormalMagnitude, alignment: .center)
        }
    }
    
    func check() {
        if (registerViewModel.userInfoModel.username.count == 0 || registerViewModel.userInfoModel.username.count < 5) {
            usernameIsCorrect = false
        } else {
            usernameIsCorrect = true
        }
        if (registerViewModel.userInfoModel.password.count == 0 || registerViewModel.userInfoModel.password.count < 8) {
            passwordIsCorrect = false
        } else {
            passwordIsCorrect = true
        }
    }
}

struct RegisterView_Previews: PreviewProvider {
    static var previews: some View {
        RegisterView()
    }
}
