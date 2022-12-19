//
//  IndexView.swift
//  app
//
//  Created by Longkun on 2022/12/17.
//

import SwiftUI

struct IndexView: View {
    
    @State var doIt: UInt8 = 0
    
    @State var showAlert: Bool = false
    
    var body: some View {
        NavigationView {
            VStack {
                Text("每日一句")
                    .font(.title2)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding()
                VStack {
                    Text("When you want to give up, remember why you started.")
                        .opacity(0.7)
                    Text("—— 佚名")
                        .opacity(0.7)
                        .frame(maxWidth: .infinity, alignment: .trailing)
                        .padding(.trailing)
                }
                // 日历展示
                Text("今日打卡")
                    .font(.title2)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding()
                VStack {
                    Picker(selection: $doIt, label: Text("今天做到了吗？")) {
                        Label("day +1", systemImage: "checkmark")
                        Label("day 0", systemImage: "xmark")
                    }
                    Button("打卡", action: {
                        print("按下打卡按钮")
                        self.showAlert = true
                    })
                    .frame(width: 200, height: 50)
                    .border(.gray)
                    .background(.green)
                    .alert(isPresented: $showAlert) {
                        Alert(
                            title: Text("打卡提示"),
                            message: Text("确定打卡？"),
                            primaryButton: .default(Text("确定"), action: {
                                
                            }),
                            secondaryButton: .default(Text("取消"), action: {
                                
                            }))
                    }
                }
                Spacer()
            }.navigationTitle(Text("首页"))
        }
    }
}

struct IndexView_Previews: PreviewProvider {
    static var previews: some View {
        IndexView()
    }
}
