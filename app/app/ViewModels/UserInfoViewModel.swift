//
//  UserInfoViewModel.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI
import Alamofire

class UserInfoViewModel: ObservableObject {
    
    @Published var userInfoModel: UserInfoModel
    
    init() {
        self.userInfoModel = UserInfoModel(id: "", uid: "", username: "", password: "", sex: "U", description: "", lastLoginTime: Date())
    }
    
    func submit(_ userInfoViewModel: UserInfoViewModel) {
        print("username: \(self.userInfoModel.username), password: \(self.userInfoModel.password), sex: \(self.userInfoModel.sex)")
        
        // 封装参数
        let parameters: [String: Any] = ["username": self.userInfoModel.username, "password": self.userInfoModel.password, "sex": self.userInfoModel.sex]
        print("请求参数: \(parameters)")
        
        // 请求服务器注册
        RequestTool.request(type: MethodType.POST, url: "/account", parameters: parameters) { res in
            print("res: \(res)")
        }
    }
    
    func resetForm() {
        self.userInfoModel.username = ""
        self.userInfoModel.password = ""
        self.userInfoModel.sex = "U"
    }
}
