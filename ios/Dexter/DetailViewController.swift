//
//  DetailViewController.swift
//  Dexter
//
//  Created by Joan Colmenero on 27/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit
import DexterShared
import MaterialComponents

class DetailViewController: UIViewController {
    
    var pokemonName: String = "default"
    internal var presenter: PokemonDetailPresenter?
    
    lazy var loading: MDCActivityIndicator = {
        let activityIndicator = MDCActivityIndicator()
        activityIndicator.translatesAutoresizingMaskIntoConstraints = false
        return activityIndicator
    }()
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupLayout()
        inject()
        
        presenter?.onViewReady(view: self, param: pokemonName)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter?.onViewDestroyed()
    }
    

}
