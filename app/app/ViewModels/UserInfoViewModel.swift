//
//  UserInfoViewModel.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI

class UserInfoViewModel: ObservableObject {
    
    @Published var userInfoModel: UserInfoModel
    
    init() {
        self.userInfoModel = UserInfoModel(id: "", uid: "", username: "", password: "", sex: "", description: "", lastLoginTime: "")
    }
    
    var newUsername: String {
        return self.userInfoModel.username + " 你好"
    }
    
    func submit(username: String, password: String, sex: String) {
        self.userInfoModel.username = username
        self.userInfoModel.password = password
        self.userInfoModel.sex = sex
        print("username: \(self.userInfoModel.username), password: \(self.userInfoModel.password), sex: \(self.userInfoModel.sex)")
    }
    
    func resetForm(username: String, password: String, sex: String) {
//        username = ""
//        password = ""
//        sex = ""
    }
}
