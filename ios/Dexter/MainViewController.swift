//
//  MainViewController.swift
//  Dexter
//
//  Created by Max Cruz on 25/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit
import DexterShared
import MaterialComponents

class MainViewController: UIViewController {
    
    internal var presenter: PokemonListPresenter?
    
    var cellId = "pokemonCellId"
    var pokemons = [Pokemon]()
    
    lazy var loading: MDCProgressView = {
        let progress = MDCProgressView()
        progress.translatesAutoresizingMaskIntoConstraints = false
        progress.heightAnchor.constraint(equalToConstant: Constants.Size.progressHeight).isActive = true
        progress.progress = 0
        progress.setHidden(true, animated: false)
        return progress
    }()
    
    lazy var pokemonList: UICollectionView = {
      let layout = UICollectionViewFlowLayout()
      let collection = UICollectionView(frame: .zero, collectionViewLayout: layout)
      layout.scrollDirection = .vertical
      collection.backgroundColor = UIColor.white
      collection.showsHorizontalScrollIndicator = false
      collection.isScrollEnabled = true
      collection.translatesAutoresizingMaskIntoConstraints = false
      return collection
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupLayout()
        inject()
        setupList()
        
        presenter?.onViewReady(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter?.onViewDestroyed()
    }
    
    private func setupList() {
        pokemonList.delegate = self
        pokemonList.dataSource = self
        pokemonList.register(PokemonViewCell.self, forCellWithReuseIdentifier: cellId)
    }
    
}

extension MainViewController: UICollectionViewDataSource {
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        pokemons.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let pokemon = pokemons[indexPath.row]
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: cellId, for: indexPath) as! PokemonViewCell
        cell.image.loadImage(url: pokemon.spriteUrl)
        cell.title.text = NSString(format: "%x. %c", pokemon.id, pokemon.name) as String
        return cell
    }
}

extension MainViewController: UICollectionViewDelegateFlowLayout {

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout,
                        sizeForItemAt indexPath: IndexPath) -> CGSize {
      let width = collectionView.frame.size.width
      let height = Constants.Size.listItemHeight
      return CGSize(width: width, height: height)
    }
}
