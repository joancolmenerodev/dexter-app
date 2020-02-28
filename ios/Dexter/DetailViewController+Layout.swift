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
        
        view.addSubview(pokemonDetailImage)
        pokemonDetailImage.topAnchor.constraint(equalTo: loading.bottomAnchor).isActive = true
        pokemonDetailImage.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        pokemonDetailImage.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        view.addSubview(pokemonDetailName)
        pokemonDetailName.topAnchor.constraint(equalTo: pokemonDetailImage.bottomAnchor).isActive = true
        pokemonDetailName.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        pokemonDetailName.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        
        let stackView = UIStackView(arrangedSubviews: [pokemonDetailHeight,spaceBetween,pokemonDetailWeight])
        view.addSubview(stackView)
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.centerXAnchor.constraint(equalTo: pokemonDetailName.centerXAnchor).isActive = true
        stackView.topAnchor.constraint(equalTo: pokemonDetailName.bottomAnchor, constant: 20).isActive = true
        


        
        
        
    }
}
