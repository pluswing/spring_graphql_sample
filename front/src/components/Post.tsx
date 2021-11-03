import React from 'react'

export interface Post {
  id: number
  author: string
  category: string
  title: string
  content: string
}

export const PostComponent = ({ post } : {post: Post}) => (
  <div>
    <div>
      {post.title} ({post.category})
    </div>
  </div>
)
