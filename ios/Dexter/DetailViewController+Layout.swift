//
//  DetailViewController+Layout.swift
//  Dexter
//
//  Created by Joan Colmenero on 27/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit

extension DetailViewController {
    
    func setupLayout() {
        view.backgroundColor = UIColor.white
        let safeGuide = view.safeAreaLayoutGuide
        
        view.addSubview(loading)
        loading.topAnchor.constraint(equalTo: safeGuide.topAnchor).isActive = true
        loading.leadingAnchor.constraint(equalTo: safeGuide.leadingAnchor).isActive = true
        loading.trailingAnchor.constraint(equalTo: safeGuide.trailingAnchor).isActive = true
        
    }
}
