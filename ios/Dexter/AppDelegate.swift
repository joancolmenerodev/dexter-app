//
//  AppDelegate.swift
//  Dexter
//
//  Created by Max Cruz on 16/01/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit
import DexterShared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    let appContainer = AppContainer(foreground: UI())

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        setupRootViewController(viewController: MainViewController())
        return true
    }

    // MARK: UISceneSession Lifecycle

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }

    func setupRootViewController(viewController: UIViewController) {
      let navigationController = UINavigationController(rootViewController: viewController)
      navigationController.setNavigationBarHidden(true, animated: false)
      window = window ?? UIWindow(frame: UIScreen.main.bounds)
      window?.rootViewController = navigationController
      window?.makeKeyAndVisible()
    }

}

