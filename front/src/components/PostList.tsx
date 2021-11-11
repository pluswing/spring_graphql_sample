import React from 'react'
import { Post, usePostsQuery } from '../generated/graphql'
import {PostComponent} from './Post'

const PostList = () => {
  const [result] = usePostsQuery();
  const { data, fetching, error } = result

  if (fetching) return <div>Fetching</div>
  if (error) return <div>Error</div>

  const postsToRender = data!.posts
  return (
    <div>
      {postsToRender.map(post => <PostComponent key={post.id} post={post} />)}
    </div>
  )
}

export default PostList
