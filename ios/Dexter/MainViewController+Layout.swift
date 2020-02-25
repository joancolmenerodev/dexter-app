//
//  MainViewController+Layout.swift
//  Dexter
//
//  Created by Max Cruz on 25/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit

extension MainViewController {
    
    func setupLayout() {
        view.backgroundColor = UIColor.white
        let safeGuide = view.safeAreaLayoutGuide
        
        view.addSubview(loading)
        loading.topAnchor.constraint(equalTo: safeGuide.topAnchor).isActive = true
        loading.leadingAnchor.constraint(equalTo: safeGuide.leadingAnchor).isActive = true
        loading.trailingAnchor.constraint(equalTo: safeGuide.trailingAnchor).isActive = true
        
        view.addSubview(pokemonList)
        pokemonList.topAnchor.constraint(equalTo: loading.bottomAnchor).isActive = true
        pokemonList.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
        pokemonList.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: Constants.Margins.margin).isActive = true
        pokemonList.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -Constants.Margins.margin).isActive = true
    }
}
