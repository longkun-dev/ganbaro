//
//  UserInfoViewModel.swift
//  app
//
//  Created by Longkun on 2022/12/11.
//

import SwiftUI
import Alamofire
import SwiftyJSON

class RegisterViewModel: ObservableObject {
    
    @Published var userInfoModel: UserInfoModel
    
    @Published var registerSuccess: Bool = false
    
    init() {
        self.userInfoModel = UserInfoModel(id: "", uid: "", username: "", password: "", sex: "U", description: "", lastLoginTime: Date())
    }
    
    func submit(_ registerViewModel: RegisterViewModel) {
        
        // 封装参数
        let parameters: [String: Any] = ["username": self.userInfoModel.username, "password": self.userInfoModel.password, "sex": self.userInfoModel.sex]
        print("请求参数: \(parameters)")
        
        // 请求服务器注册
        RequestTool.request(type: MethodType.POST, url: "/account", parameters: parameters) { res in
            print("res: \(res)")
            print(res["code"])
            print(res["message"])
            print(res["data"])
            
            self.registerSuccess = res["code"] == 201
        }
    }
}
