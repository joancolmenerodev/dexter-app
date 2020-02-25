//
//  ImageExtensions.swift
//  Dexter
//
//  Created by Max Cruz on 25/02/2020.
//  Copyright © 2020 Max Cruz. All rights reserved.
//

import UIKit
import Kingfisher

extension UIImageView {
  
  func loadImage(url: String) {
    kf.setImage(with: URL(string: url))
  }
  
}
