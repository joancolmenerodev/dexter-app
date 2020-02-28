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
    
    lazy var pokemonDetailImage: UIImageView = {
      let image = UIImageView(frame: .zero)
      image.translatesAutoresizingMaskIntoConstraints = false
      image.heightAnchor.constraint(equalToConstant: Constants.Size.imageDetailSize).isActive = true
      image.widthAnchor.constraint(equalToConstant: Constants.Size.imageDetailSize).isActive = true
      image.contentMode = .scaleAspectFit
      return image
    }()
    
    lazy var pokemonDetailName: UILabel = {
      let label = UILabel(frame: .zero)
      label.translatesAutoresizingMaskIntoConstraints = false
      label.textColor = UIColor.black
      label.font = label.font.withSize(Constants.Fonts.detailFontSize)
      label.textAlignment = .center
      return label
    }()
    
    lazy var pokemonDetailHeight: UILabel = {
      let label = UILabel(frame: .zero)
      label.translatesAutoresizingMaskIntoConstraints = false
      label.textColor = UIColor.black
      label.font = label.font.withSize(Constants.Fonts.detailFontSize)
      label.textAlignment = .center
      return label
    }()
    
    lazy var pokemonDetailWeight: UILabel = {
      let label = UILabel(frame: .zero)
      label.translatesAutoresizingMaskIntoConstraints = false
      label.textColor = UIColor.black
      label.font = label.font.withSize(Constants.Fonts.detailFontSize)
      label.textAlignment = .center
      return label
    }()
    
    lazy var spaceBetween : UIView = {
        let space = UIView()
        space.widthAnchor.constraint(equalToConstant: 40.0).isActive = true
        return space
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
