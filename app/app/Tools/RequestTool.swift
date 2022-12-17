//
//  RequestTool.swift
//  app
//
//  Created by Longkun on 2022/12/16.
//

import Swift
import Alamofire
import SwiftyJSON

let host: String = "http://debian.yuki.im:8936/api/v1"

enum MethodType {
    case GET
    case POST
    case PATCH
    case DELETE
}

class RequestTool {
    class func request(type: MethodType, url: String, parameters: [String: Any]? = nil, finishedCallback: @escaping (_ results: JSON) -> ()) {
        if (type == MethodType.GET) {
            print("get...")
            AF.request(host + url, parameters: parameters).responseData { response in
                switch response.result {
                case .success(let res):
                    let json = JSON(res)
                    finishedCallback(json)
                    break
                case .failure(let error):
                    print("request error: \(error)")
                    break
                }
            }
        } else if (type == MethodType.POST) {
            AF.request(host + url, method: .post, parameters: parameters, encoding: JSONEncoding.default).responseData { response in
                switch response.result {
                case .success(let res):
                    let json = JSON(res)
                    finishedCallback(json)
                    break
                case .failure(let error):
                    print("request error: \(error)")
                    break
                }
            }
        } else {
            print("不支持的请求方式")
        }
    }
    
    //类方法
    class func requestDataWithParam(type: MethodType, url: String, parameters: [String : Any], finishedCallback: @escaping ( _ results: Any) -> ()) {
        AF.request(host + url, parameters: parameters).responseData { (response) in
            switch response.result {
            case .success(let json):
                finishedCallback(json)
                break
            case .failure(let error):
                print("error:\(error)")
                break
            }
        }
    }
}
