//
//  File.swift
//  app
//
//  Created by Longkun on 2022/12/17.
//

import SwiftUI

class LoginViewModel: ObservableObject {
    
    @Published var userInfo: UserInfoModel
    
    @Published var loginSuccess: Bool = false
    
    init() {
        self.userInfo = UserInfoModel(id: "", uid: "", username: "", password: "", sex: "", description: "", lastLoginTime: Date(), accountStatus: "", createdTime: Date(), createdBy: "", updatedTime: Date(), updatedBy: "")
    }
    
    func login() {
        self.loginSuccess = true
//        let parameter: [String: Any] = ["uid": self.userInfo.uid, "password": self.userInfo.password]
//        RequestTool.request(type: MethodType.GET, url: "/login", parameters: parameter) { res in
//            print("res: \(res)")
            
//            self.loginSuccess = res["code"] == 200
//        }
    }
}
