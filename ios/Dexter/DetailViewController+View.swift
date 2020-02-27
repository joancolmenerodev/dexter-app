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
        
    }
    
    func showPokemonImage(url: String) {
        
    }

    func showHeight(height: String){
        
    }
    
    func showWeight(weight: String) {
        
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
