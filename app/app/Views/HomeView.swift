//
//  HomeView.swift
//  app
//
//  Created by Longkun on 2022/12/17.
//

import SwiftUI

struct HomeView: View {
    
    @ObservedObject var loginViewModel = LoginViewModel()
    
    @State var loginSuccess: Bool = false
    
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
                    Image(systemName: "house")
                    Text("首页")
                })
            Text("Page 2")
                .tabItem({
                    Image(systemName: "gear")
                    Text("Gear")
                })
        }
        .background(Color.gray)
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(loginSuccess: true)
    }
}
