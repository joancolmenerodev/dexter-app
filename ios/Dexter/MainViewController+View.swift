//
//  MainViewController+View.swift
//  Dexter
//
//  Created by Max Cruz on 25/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import DexterShared
import UIKit
import MaterialComponents.MaterialSnackbar

extension MainViewController: PokemonListView {
    func navigateToDetail(pokemonName: String) {
        let detailViewController = DetailViewController()
        detailViewController.pokemonName = pokemonName
        navigationController?.pushViewController(detailViewController, animated: true)
    }
    
    func showLoading() {
        loading.startAnimating()
    }
    
    func hideLoading() {
        loading.stopAnimating()
    }
    
    func showServiceError() {
        let message = MDCSnackbarMessage()
        message.text = NSLocalizedString("error_service", comment: "")
        MDCSnackbarManager.show(message)
    }
    
    func showPokemons(list: [Pokemon]) {
        pokemons = list
        pokemonList.reloadData()
    }
    
    func inject() {
        let appContainer = (UIApplication.shared.delegate as! AppDelegate).appContainer
        presenter = appContainer.pokemonListPresenterFactory.create()
    }
    
}
