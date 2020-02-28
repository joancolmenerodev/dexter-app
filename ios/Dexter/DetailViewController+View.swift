//
//  DetailViewController+View.swift
//  Dexter
//
//  Created by Joan Colmenero on 27/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import DexterShared
import UIKit
import MaterialComponents.MaterialSnackbar

extension DetailViewController : PokemonDetailView {
    
    func showLoading() {
        loading.startAnimating()
    }
    
    func hideLoading() {
        loading.stopAnimating()
    }
    
    func showPokemonName(name: String){
        pokemonDetailName.text = name
    }
    
    func showPokemonImage(url: String) {
        pokemonDetailImage.loadImage(url: url)
    }

    func showHeight(height: String){
        pokemonDetailHeight.text = ("Height: \(height)")
    }
    
    func showWeight(weight: String) {
        pokemonDetailWeight.text = ("Weight: \(weight)")
    }
    
    func showError(){
        let message = MDCSnackbarMessage()
        message.text = NSLocalizedString("error_service", comment: "")
        MDCSnackbarManager.show(message)
    }
    
    func inject() {
        let appContainer = (UIApplication.shared.delegate as! AppDelegate).appContainer
        presenter = appContainer.pokemonDetailPresenterFactory.create()
    }
    
}
