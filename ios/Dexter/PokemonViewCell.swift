//
//  PokemonViewCell.swift
//  Dexter
//
//  Created by Max Cruz on 25/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit

class PokemonViewCell: UICollectionViewCell {
    
    lazy var image: UIImageView = {
      let image = UIImageView(frame: .zero)
      image.translatesAutoresizingMaskIntoConstraints = false
      image.heightAnchor.constraint(equalToConstant: Constants.Size.imageSize).isActive = true
      image.widthAnchor.constraint(equalToConstant: Constants.Size.imageSize).isActive = true
      image.contentMode = .scaleAspectFit
      return image
    }()
    
    lazy var title: UILabel = {
      let label = UILabel(frame: .zero)
      label.translatesAutoresizingMaskIntoConstraints = false
      label.textColor = UIColor.black
      label.font = label.font.withSize(Constants.Fonts.fontSize)
      label.textAlignment = .center
      return label
    }()
    
    override init(frame: CGRect) {
      super.init(frame: frame)
      setupLayout()
    }
    
    required init?(coder aDecoder: NSCoder) {
      fatalError("init(coder:) has not been implemented")
    }
    
    func collectionView(collectionView: UICollectionView, didSelectItemAtIndexPath indexPath: NSIndexPath) {
        print(title.text)
    }
    
    private func setupLayout() {
        addSubview(image)
        image.topAnchor.constraint(equalTo: topAnchor).isActive = true
        image.leadingAnchor.constraint(equalTo: leadingAnchor).isActive = true
        image.trailingAnchor.constraint(equalTo: trailingAnchor).isActive = true
        
        addSubview(title)
        title.leadingAnchor.constraint(equalTo: leadingAnchor).isActive = true
        title.trailingAnchor.constraint(equalTo: trailingAnchor).isActive = true
        title.bottomAnchor.constraint(equalTo: bottomAnchor).isActive = true
    }
}
