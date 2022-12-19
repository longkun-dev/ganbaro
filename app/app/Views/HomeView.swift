//
//  HomeView.swift
//  app
//
//  Created by Longkun on 2022/12/17.
//

import SwiftUI

struct HomeView: View {
    
    @ObservedObject var loginViewModel = LoginViewModel()
    
    @State var loginSuccess: Bool = true
    
    var body: some View {
        ZStack {
            if !loginSuccess {
                LoginView(loginSuccess: self.$loginSuccess)
            } else {
                MyTabView()
            }
        }
    }
}

struct MyTabView: View {
    var body: some View {
        TabView {
            IndexView()
                .tabItem({
                    Image(systemName: "house.fill")
                    Text("首页")
                })
            StatView()
                .tabItem({
                    Image(systemName: "clock.fill")
                    Text("统计")
                })
            RankView()
                .tabItem({
                    Image(systemName: "list.star")
                    Text("排名")
                })
            ProfileView()
                .tabItem({
                    Image(systemName: "person.fill")
                    Text("我的")
                })
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(loginSuccess: true)
    }
}
