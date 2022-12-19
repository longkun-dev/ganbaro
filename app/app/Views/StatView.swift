//
//  StatView.swift
//  app
//
//  Created by Longkun on 2022/12/19.
//

import SwiftUI

struct StatView: View {
    
    private var month: String = "二月 2022"
    private var symbols = ["一", "二", "三", "四", "五", "六", "七"]
    
    private var gridItemLayout = [
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center),
        GridItem.init(.flexible(), spacing: 0, alignment: .center)
    ]
    
    var width: CGFloat = UIScreen.main.bounds.width
    
    var body: some View {
        NavigationView {
            VStack {
                // 日历展示
                Text("本月统计")
                    .font(.title2)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding()
                VStack {
                    Text("\(month)")
                        .bold()
                    LazyVGrid(columns: gridItemLayout, spacing: 15) {
                        ForEach((symbols), id: \.self) { item in
                            Text("\(item)")
                                .font(.body)
                        }
                        ForEach((1...28), id: \.self) { item in
                            if item % 6 == 0 || item % 7 == 0 {
                                Text("\(item)")
                                    .bold()
                                    .opacity(0.9)
                                    .foregroundColor(.pink)
                            } else {
                                Text("\(item)")
                                    .opacity(0.7)
                            }
                        }
                    }
                }
                Spacer()
            }.navigationTitle("统计")
        }
    }
}
