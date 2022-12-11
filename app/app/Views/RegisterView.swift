//
//  ContentView.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI

struct RegisterView: View {
    
    @ObservedObject private var userInfoViewModel = UserInfoViewModel()
    
    @State var username: String = ""
    @State var password: String = ""
    @State var sex: String = ""

    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            HStack {
                Image(systemName: "person.fill")
                TextField("请输入用户名", text: $username)
            }
            Divider()
            HStack {
                Image(systemName: "lock.fill")
                TextField("请输入密码", text: $password)
            }
            .padding(.top, 20)
            Divider()
            HStack {
                Image(systemName: "sun.max.fill")
                Picker(selection: self.$sex, label: Text("请选择性别")) {
                    Text("保密").tag("U")
                    Text("男").tag("M")
                    Text("女").tag("F")
                }
            }
            .padding(.top, 20)
            Divider()
            HStack {
                Button("注册", action: {
                    self.userInfoViewModel.submit(username: username, password: password, sex: sex)
                })
                    .padding(.trailing, 35)
                Button("重置", action: {
                    self.userInfoViewModel.resetForm(username: username, password: password, sex: sex)
                })
            }
            .padding(.top, 80)
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .leastNormalMagnitude, alignment: .center)
            Spacer()
        }
        .padding(.top, 100)
        .padding(.leading, 25)
        .padding(.trailing, 25)
    }
}

struct RegisterView_Previews: PreviewProvider {
    static var previews: some View {
        RegisterView()
    }
}
