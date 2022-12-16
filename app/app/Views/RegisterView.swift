//
//  ContentView.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI

struct RegisterView: View {
    
    @ObservedObject var userInfoViewModel = UserInfoViewModel()
    
    var body: some View {
        NavigationView {
            Form {
                Section(header: Text("基本信息")) {
                    HStack {
                        Image(systemName: "person.fill")
                        TextField("请输入用户名", text: $userInfoViewModel.userInfoModel.username)
                            .disableAutocorrection(true)
                    }
                    HStack {
                        Image(systemName: "lock.fill")
                        TextField("请输入密码", text: $userInfoViewModel.userInfoModel.password)
                            .disableAutocorrection(true)
                    }
                }
                Section(header: Text("性别")) {
                    HStack {
                        Image(systemName: "sun.max.fill")
                        Picker(selection: self.$userInfoViewModel.userInfoModel.sex, label: Text("请选择性别")) {
                            Text("保密").tag("U")
                            Text("男").tag("M")
                            Text("女").tag("F")
                        }
                    }
                }
                HStack {
                    Button("注册", action: {
                        self.userInfoViewModel.submit(self.userInfoViewModel)
                    }).buttonStyle(DefaultButtonStyle())
                    Button("重置", action: {
                        self.userInfoViewModel.resetForm()
                    })
                    .buttonStyle(.borderless)
                }.frame(maxWidth: .infinity, maxHeight: .infinity)
            }.navigationTitle("注册")
        }
    }
}

struct RegisterView_Previews: PreviewProvider {
    static var previews: some View {
        RegisterView()
    }
}
